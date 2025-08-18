using System;
using System.IO;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Azure.WebJobs;
using Microsoft.Azure.WebJobs.Extensions.Http;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;
using Azure.Messaging.EventHubs.Consumer;
using Azure.Storage.Blobs;
using Azure.Messaging.EventHubs;
using Azure.Messaging.EventHubs.Processor;
using System.Data.SqlClient;
using System.Text;
using Microsoft.Azure.Services.AppAuthentication;
using System.Net.Http;
using Azure.Storage.Blobs.Models;
using System.Linq;
using System.Data;
using Newtonsoft.Json.Linq;

namespace DataApi.Level1getDlakeV2Files.FunctionApp
{
    public static class Function2
    {
        [FunctionName("Function2")]
        public static async Task<IActionResult> Run(
            [HttpTrigger(AuthorizationLevel.Function, "get", "post", Route = null)] HttpRequest req,
            ILogger log)
        {
            
            string blobstorageconnection = Environment.GetEnvironmentVariable("dlv2");
            string blobContainer = "raw";
            string str = Environment.GetEnvironmentVariable("sqldb");
            BlobContainerClient bc = new BlobContainerClient(blobstorageconnection, blobContainer);
            
            
            var resultBlob = bc.GetBlobs().Where(m => m.Properties.LastModified.Value.Date == DateTime.Today.Date).ToList();
            
            var output = JsonConvert.SerializeObject(resultBlob);

            
            using (SqlConnection conn = new SqlConnection(str))
            {
                conn.Open();

                using (SqlCommand cmd = new SqlCommand("dbo.getTodaysFiles", conn))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    cmd.Parameters.Add(new SqlParameter("@Files", output));
                    cmd.ExecuteReader();

                }

            }
           
    
            log.LogInformation("C# HTTP trigger function processed a request.@" + output);
            
            return new OkObjectResult(new JObject().ToString());
        }

 
    }
}
