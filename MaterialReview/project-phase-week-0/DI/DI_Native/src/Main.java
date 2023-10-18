public class Main {
  public static void main(String[] args) {
    GFACodingServiceProvider gfaCodingServiceProvider = new GFACodingServiceProvider(new PythonCodingService());
    gfaCodingServiceProvider.provideLanguageService();
  }
}
