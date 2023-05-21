public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        CsvToTextConverter test1 = new CsvToTextConverter(
                "OSA2-21-05\\files\\test.csv",
                "OSA2-21-05\\files\\out-test.txt",
                ";");
        CsvToXmlConverter test2 = new CsvToXmlConverter(
                "OSA2-21-05\\files\\test.csv",
                "OSA2-21-05\\files\\out-test.xml",
                ";");
        CsvToHtmlConverter test3 = new CsvToHtmlConverter(
                "OSA2-21-05\\files\\test.csv",
                "OSA2-21-05\\files\\out-test.html",
                ";",
                "<html>\n<head><title>CsvToHtml</title></head>\n<body>\n",
                "table",
                "tr",
                "td",
                "</body>\n</html>");

        test1.convert();
        test2.convert();
        test3.convert();
    }
}