package pages;

public class AllPage {
    public AllPage() {}
    private MainPage homePage;
    private SigninPage contactusPage;

    public SigninPage contactusPage(){
        if (contactusPage==null){
            contactusPage=new SigninPage();
        }return contactusPage;
    }

    public MainPage homePage(){
        if (homePage==null){
            homePage=new MainPage();
        }return homePage;
    }
}
