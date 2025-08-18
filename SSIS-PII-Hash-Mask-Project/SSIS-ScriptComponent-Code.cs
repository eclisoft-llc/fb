#region Help:  Introduction to the Script Component
/* The Script Component allows you to perform virtually any operation that can be accomplished in
 * a .Net application within the context of an Integration Services data flow.
 *
 * Expand the other regions which have "Help" prefixes for examples of specific ways to use
 * Integration Services features within this script component. */
#endregion

#region Namespaces
using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using Microsoft.SqlServer.Dts.Pipeline.Wrapper;
using Microsoft.SqlServer.Dts.Runtime.Wrapper;
#endregion

/// <summary>
/// This is the class to which to add your code.  Do not change the name, attributes, or parent
/// of this class.
/// </summary>
[Microsoft.SqlServer.Dts.Pipeline.SSISScriptComponentEntryPointAttribute]
public class ScriptMain : UserComponent
{
    #region Help:  Using Integration Services variables and parameters
    /* To use a variable in this script, first ensure that the variable has been added to
     * either the list contained in the ReadOnlyVariables property or the list contained in
     * the ReadWriteVariables property of this script component, according to whether or not your
     * code needs to write into the variable.  To do so, save this script, close this instance of
     * Visual Studio, and update the ReadOnlyVariables and ReadWriteVariables properties in the
     * Script Transformation Editor window.
     * To use a parameter in this script, follow the same steps. Parameters are always read-only.
     *
     * Example of reading from a variable or parameter:
     *  DateTime startTime = Variables.MyStartTime;
     *
     * Example of writing to a variable:
     *  Variables.myStringVariable = "new value";
     */
    #endregion

    #region Help:  Using Integration Services Connnection Managers
    /* Some types of connection managers can be used in this script component.  See the help topic
     * "Working with Connection Managers Programatically" for details.
     *
     * To use a connection manager in this script, first ensure that the connection manager has
     * been added to either the list of connection managers on the Connection Managers page of the
     * script component editor.  To add the connection manager, save this script, close this instance of
     * Visual Studio, and add the Connection Manager to the list.
     *
     * If the component needs to hold a connection open while processing rows, override the
     * AcquireConnections and ReleaseConnections methods.
     * 
     * Example of using an ADO.Net connection manager to acquire a SqlConnection:
     *  object rawConnection = Connections.SalesDB.AcquireConnection(transaction);
     *  SqlConnection salesDBConn = (SqlConnection)rawConnection;
     *
     * Example of using a File connection manager to acquire a file path:
     *  object rawConnection = Connections.Prices_zip.AcquireConnection(transaction);
     *  string filePath = (string)rawConnection;
     *
     * Example of releasing a connection manager:
     *  Connections.SalesDB.ReleaseConnection(rawConnection);
     */
    #endregion

    #region Help:  Firing Integration Services Events
    /* This script component can fire events.
     *
     * Example of firing an error event:
     *  ComponentMetaData.FireError(10, "Process Values", "Bad value", "", 0, out cancel);
     *
     * Example of firing an information event:
     *  ComponentMetaData.FireInformation(10, "Process Values", "Processing has started", "", 0, fireAgain);
     *
     * Example of firing a warning event:
     *  ComponentMetaData.FireWarning(10, "Process Values", "No rows were received", "", 0);
     */
    #endregion

    /// <summary>
    /// This method is called once, before rows begin to be processed in the data flow.
    ///
    /// You can remove this method if you don't need to do anything here.
    /// </summary>
    public override void PreExecute()
    {
        base.PreExecute();
        string fpath = Variables.connstr;
        string[] allLines = File.ReadAllLines(fpath);
        allcolls = new Dictionary<int, string>();
        hashcols = new Dictionary<string, string>();
        maskcols = new Dictionary<string, string>();

        string[] fh = allLines[0].Split('\t');

        sb = allLines[0];

        string h = "";

        for (int i = 0; i < fh.Length; i++)
            allcolls.Add(i, fh[i]);


        if (!string.IsNullOrEmpty(Variables.hashcols))
        {
            string[] a = Variables.hashcols.Split(',');

            for (int i = 0; i < a.Length; i++)
            {
                hashcols.Add(a[i], a[i]);
                h += a[i] + "\t";

            }

        }
        int x = fh.Length;
        if (!string.IsNullOrEmpty(Variables.maskcols))
        {
            string[] b = Variables.maskcols.Split(',');

            for (int i = 0; i < b.Length; i++)
            {
                maskcols.Add(b[i] + "MASKED", b[i] + "MASKED");
                
                allcolls.Add(x++, b[i] + "MASKED");
                sb += "\t" + b[i] + " MASKED\t";

            }

        }

        sb = sb.TrimEnd('\t');
    }

    /// <summary>
    /// This method is called after all the rows have passed through this component.
    ///
    /// You can delete this method if you don't need to do anything here.
    /// </summary>
    public override void PostExecute()
    {
        base.PostExecute();
        /*
         * Add your code here
         */
    }
    private Dictionary<string, string> hashcols;
    private Dictionary<string, string> maskcols;
    private Dictionary<int, string> allcolls;
    private string sb;
    private bool ishead = false;
    public override void CreateNewOutputRows()
    {
        if (!ishead)
        {
            Output0Buffer.AddRow();
            Output0Buffer.Data = sb;
            ishead = true;

        }

        string npiSaltedHash = "";

        string saltedKey = Variables.saltedkey;
        string vv = "";
        string l = "";

        string fpath = Variables.connstr;
        string[] allLines = File.ReadAllLines(fpath);

        string[] fh = allLines[0].Split('\t');
        string[] v = null;
        for(int i =1; i<allLines.Length-1; i++)
        {
            v = allLines[i].Split('\t');
            l = "";

          foreach (KeyValuePair<int,string> k in allcolls)
            {
                
                if (hashcols.ContainsKey(k.Value))
                {
                    
                    if (hashcols[k.Value] == k.Value)
                    {
                        vv = v[k.Key];
                        npiSaltedHash = GenerateSaltedHash(vv, saltedKey);
                        l += npiSaltedHash + "\t";

                    }
                }
                else
                {
                    if (!maskcols.ContainsKey(k.Value))
                    {
                        vv = v[k.Key];
                        l += vv + "\t";
                    }
                }

                if (maskcols.ContainsKey(k.Value))
                {
                    
                    if (maskcols[k.Value] == k.Value)
                    {
                        var kk = allcolls.FirstOrDefault(x => x.Value == k.Value.Replace("MASKED","")).Key;
                        vv = v[kk];
                        if (IsValidEmail(vv))
                            l += EmailMask(vv) + "\t";
                        else if (!string.IsNullOrEmpty(Variables.colmask))
                            l += PartialMask(vv, Variables.firstval, Variables.lastval, Variables.colmask.ToCharArray()[0]) + "\t";
                        else
                            l += DefaultMask(vv) + "\t";
                    }
                }
            }
            l = l.TrimEnd('\t');

            Output0Buffer.AddRow();
            Output0Buffer.Data = l;
        }


    }

    public static string GenerateSaltedHash(string value, string storedSalt)
    {
        var saltBytes = Convert.FromBase64String(storedSalt);
        //Without the fourth parameter, the default algorithm used is SHA1
        var rfc2898DeriveBytes = new Rfc2898DeriveBytes(value, saltBytes, 10000, HashAlgorithmName.SHA256);
        var hashedValue = Convert.ToBase64String(rfc2898DeriveBytes.GetBytes(64));
        return hashedValue;
    }

    public static string DefaultMask(object sourceValue, char maskCharacter = 'X')
    {
        if (sourceValue == null)
            return string.Empty;

        string maskedString = string.Empty;

        if (sourceValue is string)
        {
            maskedString = new string(maskCharacter, 4);
        }
        else if (sourceValue is int || sourceValue is long)
        {
            maskedString = "0";
        }
        else if (sourceValue is double || sourceValue is decimal || sourceValue is float)
        {
            maskedString = "0.00";
        }
        else if (sourceValue is DateTime)
        {
            maskedString = "1900-01-01";
        }

        return maskedString;

    }//end of DefaultMask method

    /// <summary>
    /// Mask email addresses. Masks all but the first letter followed by XXX, followed by @ sign, followed by XXXX and exposes the domain suffix (like .com, .org etc..).
    /// </summary>
    /// <param name="email">Email address to mask.</param>
    /// <returns>Mask email address in the format "aXXX@XXXX.com".</returns>
    public static string EmailMask(string email)
    {
        if (string.IsNullOrEmpty(email) || !email.Contains("@"))
            return email;

        string[] emailArr = email.Split('@');
        string domainExt = Path.GetExtension(email);

        string maskedEmail = string.Format("{0}XXX@XXXX{1}",
           emailArr[0][0],
           domainExt
           );

        return maskedEmail;

    }//end of EmailMask method

    /// <summary>
    /// Allows you to define exactly which values are masked. This function works best for values that is consistently formatted, such as credit card numbers or national IDs.
    /// </summary>
    /// <param name="sourceValue">Source value to mask.</param>
    /// <param name="leadingOpenCharacters">Prefix characters to be exposed.</param>
    /// <param name="trailingOpenCharacters">Suffix characters to be exposed.</param>
    /// <param name="maskCharacter">Character to use for masking. Default is "X".</param>
    /// <returns>Custom mask (e.g. 12XXXXXXX2, XXXXX3, ****21 etc.).</returns>
    public static string PartialMask(string sourceValue, int leadingOpenCharacters = 1, int trailingOpenCharacters = 1, char maskCharacter = 'X')
    {
        if (string.IsNullOrEmpty(sourceValue))
            return sourceValue;

        string maskedString = string.Empty;
        int stringLength = sourceValue.Length;
        string openCharacters = sourceValue.Substring(0, leadingOpenCharacters);
        string trailingCharacters = stringLength > trailingOpenCharacters ? sourceValue.Substring(stringLength - trailingOpenCharacters) : string.Empty;

        int middleCharactersLength = (stringLength - leadingOpenCharacters) - (stringLength > trailingOpenCharacters ? trailingOpenCharacters : 0);

        if (stringLength == 1)
        {
            maskedString = new string(maskCharacter, 1);
        }
        else
        {
            maskedString = string.Format("{0}{1}{2}",
           openCharacters,
           new string(maskCharacter, (middleCharactersLength == 0 ? 1 : middleCharactersLength)),
           trailingCharacters
           );
        }

        return maskedString;

    }//end of PartialMask method

    /// <summary>
    /// Replaces numerical values with a random value within a specified range.
    /// </summary>
    /// <param name="sourceValue">Source value.</param>
    /// <param name="randomRange">Specified range (like 1 for range between 1 and 9, 2 for range between 101 and 999 etc..).</param>
    /// <returns>Random number within a defined range (e.g. 10, 231, 1002, 53423 etc.).</returns>
    public static string RandomMask(object sourceValue, int randomRange = 5)
    {

        if (sourceValue == null)
            return null;

        Random rand = new Random();
        int randomValue;
        switch (randomRange)
        {
            case 1:
                randomValue = rand.Next(1, 9);
                break;
            case 2:
                randomValue = rand.Next(10, 99);
                break;
            case 3:
                randomValue = rand.Next(100, 999);
                break;
            case 4:
                randomValue = rand.Next(1000, 9999);
                break;
            case 5:
                randomValue = rand.Next(10000, 99999);
                break;
            case 6:
                randomValue = rand.Next(100000, 999999);
                break;
            default:
                randomValue = rand.Next(10000, 99999);
                break;
        }

        return randomValue.ToString();

    }//end of RandomMask method

    bool IsValidEmail(string email)
    {
        try
        {
            var addr = new System.Net.Mail.MailAddress(email);
            return addr.Address == email;
        }
        catch
        {
            return false;
        }
    }

}
