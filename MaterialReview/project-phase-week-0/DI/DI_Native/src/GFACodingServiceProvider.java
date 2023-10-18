public class GFACodingServiceProvider {
  private CodingService codingService;

  public GFACodingServiceProvider(CodingService codingService) {
    this.codingService = codingService;
  }

  public void provideLanguageService() {
    codingService.guideApprentices();
  }
}
