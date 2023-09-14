
package notepad_stack;
import java.awt.Font;

public class Format {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;
    
    public Format(GUI gui)
    {
        this.gui = gui;
    }
    
    public void wordWrap()
    {
        if(!gui.wordWrapOn)
        {
            gui.wordWrapOn =true;
            gui.textarea.setLineWrap(true);
            gui.textarea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap : ON");
        }
        
        else
        {
            gui.wordWrapOn = false;
            gui.textarea.setLineWrap(false);
            gui.textarea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap : OFF");
          }
       }
    
    public void createFont(int fontSize)
    {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        
        
        setFont(selectedFont);
        
    }
    
    public void setFont(String font)
    {
        selectedFont = font;
        
        switch(selectedFont)
        {
            case "Arial" :
                gui.textarea.setFont(arial);
                break;
             
            case "Comic Sans MS":
                gui.textarea.setFont(comicSansMS);
                break;
             
            case "Times New Roman":
                gui.textarea.setFont(timesNewRoman);
                break;
           
            default:
                break;
                
           }
      }
    
    public static void main(String args[])
    {
        
    }
}
