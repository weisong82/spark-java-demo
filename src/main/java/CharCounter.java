import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

/**
 * Created by wei on 2017/10/8.
 */
public class CharCounter {
    public static void main(String[] args) {
        String logFile = "/Users/wei/Downloads/spark-2.2.0-bin-hadoop2.7/README.md";
        SparkSession spark = SparkSession.builder().getOrCreate();
        Dataset<String> logData = spark.read().textFile(logFile);

        long numAs = logData.filter((FilterFunction<String>) s -> s.contains("a")).count();

        System.out.println(numAs);

        spark.stop();
    }
}