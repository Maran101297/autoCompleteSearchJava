// import java.io.IOException;
// import java.io.OutputStream;
// import java.net.InetSocketAddress;
// import java.security.Key;
// import java.util.*;

// import com.sun.net.httpserver.*;
// import java.util.stream.*;
// public class AutoSearch {

//     // private static final List<String> VARIABLES = Arrays.asList("A", "B", "C", "D", "E", "F");
// //    private static final List<String> VARIABLES = 
// //         IntStream.rangeClosed('A', 'Z')
// //                  .mapToObj(c -> String.valueOf((char)c))
// //                  .collect(Collectors.toList());

//     //             private static final List<String> VARIABLES = 
//     // java.util.stream.IntStream.rangeClosed('A', 'Z')
//     //     .mapToObj(c -> String.valueOf((char)c))
//     //     .collect(java.util.stream.Collectors.toList());
//     private static final List<String> VARIABLES = Arrays.asList(
//     "InstanceId",
//     "InstanceType",
//     "Region",
//     "AvailabilityZone",
//     "VpcId",
//     "SubnetId",
//     "SecurityGroup",
//     "AccountId",
//     "UserId",
//     "Role",
//     "Service",
//     "Resource",
//     "TagKey",
//     "TagValue",
//     "Action",
//     "RequestId",
//     "BucketName",
//     "ObjectKey",
//     "AADNF"
// );



// private static final Map<String, List<String>> VARIABLE_VALUES = new HashMap<>();

// static {
//     VARIABLE_VALUES.put("InstanceId", Arrays.asList(
//         "i-001", "i-002", "i-003", "i-004", "i-005",
//         "i-006", "i-007", "i-008", "i-009", "i-010",
//         "i-011", "i-012", "i-013", "i-014", "i-015"
//     ));

//     VARIABLE_VALUES.put("InstanceType", Arrays.asList(
//         "t2.micro", "t2.small", "t2.medium", "t2.large", "t3.micro",
//         "t3.small", "t3.medium", "t3.large", "m5.large", "m5.xlarge",
//         "m5.2xlarge", "m5.4xlarge", "c5.large", "c5.xlarge", "c5.2xlarge"
//     ));

//     VARIABLE_VALUES.put("Region", Arrays.asList(
//         "us-east-1", "us-east-2", "us-west-1", "us-west-2", "eu-west-1",
//         "eu-west-2", "eu-central-1", "ap-south-1", "ap-northeast-1",
//         "ap-northeast-2", "ap-southeast-1", "ap-southeast-2",
//         "sa-east-1", "ca-central-1", "af-south-1"
//     ));

//     VARIABLE_VALUES.put("AvailabilityZone", Arrays.asList(
//         "us-east-1a", "us-east-1b", "us-east-1c", "us-east-1d", "us-east-1e",
//         "us-east-2a", "us-east-2b", "us-east-2c", "us-west-2a", "us-west-2b",
//         "us-west-2c", "eu-west-1a", "eu-west-1b", "eu-west-1c", "ap-south-1a"
//     ));

//     VARIABLE_VALUES.put("VpcId", Arrays.asList(
//         "vpc-001", "vpc-002", "vpc-003", "vpc-004", "vpc-005",
//         "vpc-006", "vpc-007", "vpc-008", "vpc-009", "vpc-010",
//         "vpc-011", "vpc-012", "vpc-013", "vpc-014", "vpc-015"
//     ));

//     VARIABLE_VALUES.put("SubnetId", Arrays.asList(
//         "subnet-001", "subnet-002", "subnet-003", "subnet-004", "subnet-005",
//         "subnet-006", "subnet-007", "subnet-008", "subnet-009", "subnet-010",
//         "subnet-011", "subnet-012", "subnet-013", "subnet-014", "subnet-015"
//     ));

//     VARIABLE_VALUES.put("SecurityGroup", Arrays.asList(
//         "sg-001", "sg-002", "sg-003", "sg-004", "sg-005",
//         "sg-006", "sg-007", "sg-008", "sg-009", "sg-010",
//         "sg-011", "sg-012", "sg-013", "sg-014", "sg-015"
//     ));

//     VARIABLE_VALUES.put("AccountId", Arrays.asList(
//         "111111111111", "222222222222", "333333333333", "444444444444", "555555555555",
//         "666666666666", "777777777777", "888888888888", "999999999999", "123456789012",
//         "210987654321", "314159265358", "987654321000", "456789123456", "159753258147"
//     ));

//     VARIABLE_VALUES.put("UserId", Arrays.asList(
//         "user1", "user2", "user3", "user4", "user5",
//         "user6", "user7", "user8", "user9", "user10",
//         "user11", "user12", "user13", "user14", "user15"
//     ));

//     VARIABLE_VALUES.put("Role", Arrays.asList(
//         "Admin", "Developer", "Viewer", "Auditor", "Support",
//         "DevOps", "Security", "Billing", "DataEngineer", "Analyst",
//         "Operator", "Architect", "Tester", "Researcher", "Intern"
//     ));

//     VARIABLE_VALUES.put("Service", Arrays.asList(
//         "EC2", "S3", "IAM", "RDS", "DynamoDB",
//         "Lambda", "CloudWatch", "CloudTrail", "VPC", "EKS",
//         "ECS", "SNS", "SQS", "Kinesis", "Glue"
//     ));

//     VARIABLE_VALUES.put("Resource", Arrays.asList(
//         "arn:aws:s3:::bucket1", "arn:aws:s3:::bucket2", "arn:aws:ec2:::instance1",
//         "arn:aws:ec2:::instance2", "arn:aws:rds:::db1", "arn:aws:rds:::db2",
//         "arn:aws:lambda:::function1", "arn:aws:lambda:::function2",
//         "arn:aws:dynamodb:::table1", "arn:aws:dynamodb:::table2",
//         "arn:aws:cloudwatch:::alarm1", "arn:aws:cloudwatch:::alarm2",
//         "arn:aws:iam:::role/Admin", "arn:aws:iam:::role/DevOps",
//         "arn:aws:eks:::cluster1"
//     ));

//     VARIABLE_VALUES.put("TagKey", Arrays.asList(
//         "Environment", "Project", "Owner", "CostCenter", "Application",
//         "Department", "Team", "Region", "Backup", "Compliance",
//         "Purpose", "Stage", "Version", "Role", "Criticality"
//     ));

//     VARIABLE_VALUES.put("TagValue", Arrays.asList(
//         "Prod", "Dev", "Test", "QA", "Staging",
//         "Finance", "HR", "Marketing", "Sales", "Ops",
//         "Critical", "Optional", "Internal", "External", "Legacy"
//     ));

//     VARIABLE_VALUES.put("Action", Arrays.asList(
//         "ec2:StartInstances", "ec2:StopInstances", "ec2:RebootInstances", "s3:PutObject",
//         "s3:GetObject", "s3:DeleteObject", "iam:CreateUser", "iam:DeleteUser",
//         "lambda:InvokeFunction", "dynamodb:PutItem", "dynamodb:GetItem", "rds:StartDBInstance",
//         "rds:StopDBInstance", "eks:CreateCluster", "eks:DeleteCluster"
//     ));

//     VARIABLE_VALUES.put("RequestId", Arrays.asList(
//         "req-001", "req-002", "req-003", "req-004", "req-005",
//         "req-006", "req-007", "req-008", "req-009", "req-010",
//         "req-011", "req-012", "req-013", "req-014", "req-015"
//     ));

//     VARIABLE_VALUES.put("BucketName", Arrays.asList(
//         "my-app-bucket", "logs-bucket", "backup-bucket", "archive-bucket", "images-bucket",
//         "videos-bucket", "config-bucket", "static-bucket", "cdn-bucket", "db-backup-bucket",
//         "media-bucket", "documents-bucket", "temp-bucket", "prod-bucket", "test-bucket"
//     ));

//     VARIABLE_VALUES.put("ObjectKey", Arrays.asList(
//         "file1.txt", "file2.txt", "image1.png", "image2.jpg", "video1.mp4",
//         "backup1.sql", "backup2.sql", "report1.pdf", "report2.docx", "config.json",
//         "app.log", "metrics.csv", "dashboard.html", "style.css", "script.js"
//     ));
// }


//     private static final List<String> OPERATORS = Arrays.asList("==", "!=", ">", "<", ">=", "<=");
//     private static final List<String> LOGICALS  = Arrays.asList("AND", "OR");

//     public static void main(String[] args) throws Exception {
//         HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
//         server.createContext("/api/suggestions", new SuggestionHandler());
//         server.setExecutor(null);
//         server.start();
//         System.out.println("Autocomplete API running at http://localhost:8080/api/suggestions");
//     }

   

//     static class SuggestionHandler implements HttpHandler {
//         @Override
//         public void handle(HttpExchange exchange) throws IOException {
//             String response;
//             int statusCode = 200;

//             try {
//                 // Build JSON response
//                 response = "{"
//                     + "\"variables\":" + toJsonArray(VARIABLES) + ","
//                     + "\"operators\":" + toJsonArray(OPERATORS) + ","
//                     + "\"logicals\":"  + toJsonArray(LOGICALS)  + ","
//                      + "\"values\":"  + toJsonObject(VARIABLE_VALUES)  
//                     + "}";
//             } catch (Exception e) {
//                 // Error response
//                 statusCode = 500;
//                 response = "{ \"error\": \"Internal Server Error\", \"message\": \"" 
//                          + e.getMessage().replace("\"","'") + "\" }";
//                 e.printStackTrace();
//             }

//             // Send response
//             exchange.getResponseHeaders().add("Content-Type", "application/json");
//             exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
//             exchange.sendResponseHeaders(statusCode, response.getBytes().length);

//             try (OutputStream os = exchange.getResponseBody()) {
//                 os.write(response.getBytes());
//             }
//         }
//   private String toJsonObject(Map<String, List<String>> map ){
//              StringBuilder sb = new StringBuilder("{");
//     boolean first = true;
//     for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//         if (!first) sb.append(",");
//         sb.append("\"").append(entry.getKey()).append("\":");
//         sb.append(toJsonArray(entry.getValue())); 
//         first = false;
//     }
//     sb.append("}");
//     return sb.toString();
//     }
//         private String toJsonArray(List<String> list) {
//             return list.stream()
//                        .map(s -> "\"" + s + "\"")
//                        .collect(Collectors.joining(",", "[", "]"));
//         }
//     }

  
// }





import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.*;

public class AutoSearch {
    private static final List<String> VARIABLES = Arrays.asList(
        "InstanceId","InstanceType","Region","AvailabilityZone","VpcId","SubnetId","SecurityGroup",
        "AccountId","UserId","Role","Service","Resource","TagKey","TagValue","Action","RequestId",
        "BucketName","ObjectKey", "ABBBCC"
    );

    private static final Map<String, List<String>> VARIABLE_VALUES = new HashMap<>();
    static {
        VARIABLE_VALUES.put("InstanceId", Arrays.asList(
            "i-001","i-002","i-003","i-004","i-005","i-006","i-007","i-008","i-009","i-010","i-011","i-012","i-013","i-014","i-015"
        ));
        VARIABLE_VALUES.put("InstanceType", Arrays.asList(
            "t2.micro","t2.small","t2.medium","t2.large","t3.micro","t3.small","t3.medium","t3.large",
            "m5.large","m5.xlarge","m5.2xlarge","m5.4xlarge","c5.large","c5.xlarge","c5.2xlarge"
        ));
        VARIABLE_VALUES.put("Region", Arrays.asList(
            "us-east-1","us-east-2","us-west-2","eu-west-1","eu-central-1","ap-south-1","ap-northeast-1",
            "ap-southeast-1","ap-southeast-2","eu-north-1","sa-east-1","ca-central-1","af-south-1","me-south-1","ap-east-1"
        ));
        //... add other variable value lists (use earlier lists or fill)
        VARIABLE_VALUES.put("BucketName", Arrays.asList(
            "my-app-bucket","logs-bucket","backup-bucket","archive-bucket","images-bucket","videos-bucket","config-bucket",
            "static-bucket","cdn-bucket","db-backup-bucket","media-bucket","documents-bucket","temp-bucket","prod-bucket","test-bucket"
        ));
        // For any missing variable, fallback will be empty array
    }

    private static final List<String> OPERATORS = Arrays.asList("==","!=",">","<",">=","<=");
    private static final List<String> LOGICALS = Arrays.asList("AND","OR");

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/api/suggestions/meta", new MetaHandler());
        server.createContext("/api/suggestions/variables", new PagedListHandler("variables"));
        server.createContext("/api/suggestions/operators", new PagedListHandler("operators"));
        server.createContext("/api/suggestions/logicals", new PagedListHandler("logicals"));
        server.createContext("/api/suggestions/values", new ValuesHandler());

        server.setExecutor(null);
        server.start();
        System.out.println("Autocomplete API running at http://localhost:8080");
    }

    // Handler that returns counts & available endpoints
    static class MetaHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange ex) throws IOException {
            Map<String, Object> meta = new LinkedHashMap<>();
            meta.put("variablesCount", VARIABLES.size());
            meta.put("operatorsCount", OPERATORS.size());
            meta.put("logicalsCount", LOGICALS.size());
            meta.put("valuesCounts", VARIABLE_VALUES.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size())));
            String body = toJson(meta);
            sendJson(ex, 200, body);
        }
    }

    // Generic paged list: variables/operators/logicals
    static class PagedListHandler implements HttpHandler {
        private final String kind;
        PagedListHandler(String kind) { this.kind = kind; }

        @Override
        public void handle(HttpExchange ex) throws IOException {
            try {
                Map<String, String> q = queryToMap(ex.getRequestURI());
                int offset = Integer.parseInt(q.getOrDefault("offset", "0"));
                int limit  = Integer.parseInt(q.getOrDefault("limit", "10"));

                List<String> source;
                if ("variables".equals(kind)) source = VARIABLES;
                else if ("operators".equals(kind)) source = OPERATORS;
                else if ("logicals".equals(kind)) source = LOGICALS;
                else source = Collections.emptyList();

                List<String> page = slice(source, offset, limit);
                Map<String, Object> resp = new HashMap<>();
                resp.put("items", page);
                resp.put("offset", offset);
                resp.put("limit", limit);
                resp.put("total", source.size());
                sendJson(ex, 200, toJson(resp));
            } catch (Exception e) {
                e.printStackTrace();
                sendJson(ex, 500, "{\"error\":\"internal\"}");
            }
        }
    }

    // Values handler: expects ?variable=InstanceType&offset=0&limit=10
    static class ValuesHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange ex) throws IOException {
            try {
                Map<String, String> q = queryToMap(ex.getRequestURI());
                String variable = q.get("variable");
                if (variable == null || variable.isEmpty()) {
                    sendJson(ex, 400, "{\"error\":\"variable param required\"}");
                    return;
                }
                int offset = Integer.parseInt(q.getOrDefault("offset", "0"));
                int limit  = Integer.parseInt(q.getOrDefault("limit", "10"));

                List<String> all = VARIABLE_VALUES.getOrDefault(variable, Collections.emptyList());
                List<String> page = slice(all, offset, limit);

                Map<String, Object> resp = new HashMap<>();
                resp.put("variable", variable);
                resp.put("items", page);
                resp.put("offset", offset);
                resp.put("limit", limit);
                resp.put("total", all.size());
                sendJson(ex, 200, toJson(resp));
            } catch (Exception e) {
                e.printStackTrace();
                sendJson(ex, 500, "{\"error\":\"internal\"}");
            }
        }
    }

    // helpers

    /* strudy */
    private static List<String> slice(List<String> list, int offset, int limit) {
        if (offset < 0) offset = 0;
        if (limit < 0) limit = 10;
        int start = Math.min(offset, list.size());
        int end = Math.min(start + limit, list.size());
        return list.subList(start, end);
    }

    private static Map<String, String> queryToMap(URI uri) {
        Map<String, String> map = new HashMap<>();
        String q = uri.getQuery();
        if (q == null) return map;
        for (String pair : q.split("&")) {
            int idx = pair.indexOf("=");
            if (idx == -1) continue;
            String key = urlDecode(pair.substring(0, idx));
            String val = urlDecode(pair.substring(idx + 1));
            map.put(key, val);
        }
        return map;
    }

    private static String urlDecode(String s) {
        try { return java.net.URLDecoder.decode(s, "UTF-8"); }
        catch (Exception e) { return s; }
    }

    private static void sendJson(HttpExchange ex, int status, String body) throws IOException {
        ex.getResponseHeaders().add("Content-Type", "application/json; charset=utf-8");
        ex.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        ex.sendResponseHeaders(status, body.getBytes(StandardCharsets.UTF_8).length);
        try (OutputStream os = ex.getResponseBody()) {
            os.write(body.getBytes(StandardCharsets.UTF_8));
        }
    }

    // simple JSON conversion for basic structures (maps, lists, numbers, strings)
    private static String toJson(Object o) {
        if (o == null) return "null";
        if (o instanceof Map) {
            StringBuilder sb = new StringBuilder("{");
            boolean first = true;
            for (Map.Entry<?,?> e : ((Map<?,?>)o).entrySet()) {
                if (!first) sb.append(",");
                sb.append("\"").append(escape(String.valueOf(e.getKey()))).append("\":");
                sb.append(toJson(e.getValue()));
                first = false;
            }
            sb.append("}");
            return sb.toString();
        }
        if (o instanceof List) {
            StringBuilder sb = new StringBuilder("[");
            boolean first = true;
            for (Object v : (List<?>)o) {
                if (!first) sb.append(",");
                sb.append(toJson(v));
                first = false;
            }
            sb.append("]");
            return sb.toString();
        }
        if (o instanceof String) {
            return "\"" + escape((String)o) + "\"";
        }
        // numbers/booleans
        return String.valueOf(o);
    }

    private static String escape(String s) {
        return s.replace("\\","\\\\").replace("\"","\\\"").replace("\n","\\n").replace("\r","\\r");
    }
}

