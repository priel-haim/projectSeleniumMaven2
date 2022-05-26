package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AllureAttachment;

import java.util.List;

public class TechnologyQuizPage extends MenuPage {

    @FindBy(css = ".c-button.btn")
    WebElement StartBtn;
    @FindBy(css = ".btn-secondary.shadow")
    List<WebElement> Round1List;
    @FindBy(css = ".btn-secondary.shadow")
    List<WebElement> Round2List;
    @FindBy(css = ".answer-behaviour.shadow")
    List<WebElement> Round3List;
    @FindBy(css = ".btn-secondary.shadow")
    List<WebElement> Round4List;
    @FindBy(css = ".answer-behaviour.shadow")
    List<WebElement> Round5List;
    @FindBy(css = ".c-button.btn")
    WebElement NextBtn;
    @FindBy(css = ".e-headline span")
    WebElement YourFinalScore;

    public TechnologyQuizPage(WebDriver driver) {
        super(driver);

    }

    @Step("click on start")
    public void OpenTechnologyQuiz() {
        click(StartBtn);
    }

    @Step("question - Who Founded Apple Computer")
    public void WhoFoundedAppleComputer(String name) {
        List<WebElement> computer = Round1List;
        for (WebElement Round1List : computer) {
            if (getText(Round1List).contains(name)) {
                AllureAttachment.attachElementScreenshot(Round1List);
                actions.click(Round1List).click(NextBtn).build().perform();
                break;
            }
            sleep(2000);
        }
        click(NextBtn);
        sleep(2000);
    }

    @Step("What does the 'OS' abbreviation usually mean?")
    public void WhatShortcutsTheOperatingSystem(String name) {
        List<WebElement> OS = Round2List;
        for (WebElement Round2List : OS) {
            if (getText(Round2List).contains(name)) {
                AllureAttachment.attachElementScreenshot(Round2List);
                actions.click(Round2List).click(NextBtn).build().perform();
                break;
            }
            sleep(2000);
        }
        click(NextBtn);
        sleep(2000);
    }

    @Step("How many computer languages are in use?")
    public void HowManyComputersLanguagesUse(String number) {
        List<WebElement> LanguagesAreInUse = Round3List;
        for (WebElement Round3List : LanguagesAreInUse) {
            if (getText(Round3List).contains(number)) {
                AllureAttachment.attachElementScreenshot(Round3List);
                actions.click(Round3List).click(NextBtn).build().perform();
                break;
            }
            sleep(2000);
        }
        click(NextBtn);
        sleep(2000);
    }

    @Step("What does the Internet  prefix WWW stand for?")
    public void WhatDoesWWWMean(String name) {
        List<WebElement> Acronyms = Round4List;
        for (WebElement Round4List : Acronyms) {
            if (getText(Round4List).contains(name)) {
                AllureAttachment.attachElementScreenshot(Round4List);
                actions.click(Round4List).click(NextBtn).build().perform();
                break;
            }
            sleep(2000);
        }
        click(NextBtn);
        sleep(2000);
    }

    @Step("'.MOV' extension refers usually to what kind of file?")
    public void WhereToPutTheMOVExtension(String name) {
        List<WebElement> MOV = Round5List;
        for (WebElement Round5List : MOV) {
            if (getText(Round5List).contains(name)) {
                AllureAttachment.attachElementScreenshot(Round5List);
                actions.click(Round5List).click(NextBtn).build().perform();
                break;
            }
            sleep(2000);
        }
        click(NextBtn);
        sleep(2000);
    }

    @Step("Answers to all the questions of the quiz")//----
    public void AnsweringTheQuestions(String inventor, String Shortcut, String number, String Meaning, String Name) {
        WhoFoundedAppleComputer(inventor);
        WhatShortcutsTheOperatingSystem(Shortcut);
        HowManyComputersLanguagesUse(number);
        WhatDoesWWWMean(Meaning);
        WhereToPutTheMOVExtension(Name);
        sleep(1000);
    }

    @Step("Completion of the quiz")
    public String getTitle() {
        AllureAttachment.attachElementScreenshot(YourFinalScore);
        return getText(YourFinalScore);

    }
}