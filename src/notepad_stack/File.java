
package notepad_stack;
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class File {
    GUI gui;
    String fileName;
    String fileAddress;
    
    public File(GUI gui)
    {
        this.gui = gui;
    }
    
    public File(String string)
    {
        
    }
    
    public void newFile()
    {
        gui.textarea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
        
     }
    
    public void open()
    {
        FileDialog fd = new FileDialog(gui.window,  "Open", FileDialog.LOAD);
        fd.setVisible(true);
        
        if(fd.getFile() != null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
         }
        
        try
        {
           BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName)) ;
           
           gui.textarea.setText("");
           
           String line = null;
           
           while((line = br.readLine()) != null)
           {
               gui.textarea.append(line + "\n");
          }
           
           br.close();
        }
        catch(Exception e)
        {
           System.out.println("File Not Opened !");
               
        }
    }
    
    public void save()
    {
        if(fileName == null)
        {
            saveAs();
        }
        
        else
            
        {
            try
            {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(gui.textarea.getText());
                gui.window.setTitle(fileName);
                fw.close();
            }
            
            catch(Exception e)
            {
                System.out.println("Something wrong happend !");
            }
        }
    }
    
    public void saveAs()
    {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        
        
        if(fd.getFile() != null)
        {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
            
        }
        
        try
        {
            FileWriter fw = new FileWriter(fileAddress + fileName);
             fw.write(gui.textarea.getText());
             fw.close();
            
        }
        catch(Exception e)
        {
           System.out.println("Something wrong happened !");
        }
    }
    
    public void exit()
    {
        System.exit(0);
    }
}
