/**
 * FILE		    :	UFO Sightings
 * Author		:	Vinod Kumar Nair (WIPRO)
 * Purpose	    :	It is default or package-private class which will be used as property reader class to read the given CSV file using property file
 * Date Created :	05-01-2018
 *
 * @history <<DD>> <<MON>> <<YYYY>> << DEVELOPER >> - << CHANGES DONE >>.
 *            05-01-2018 : Vinod Kumar - Logic written for first time as per given requirements for UFO Sightings App
 */

package ufo.util;
import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

class PropertyReader {
    protected static Logger logger = Logger.getLogger("PropertyReader");
    public static Properties fileProperties = null;

    static {
        try{
            if (fileProperties == null) {
                fileProperties = PropertyReader.getFileProperties("src/main/config/properties/file.properties");
                System.out.println("File Properties: " + fileProperties);
            }
        }
        catch(Exception e){
            System.out.println("Exception while loading properties file : "+e);
            System.exit(0);
        }
    }

    protected static Properties getFileProperties(String fileName) throws IOException {
        InputStream inputStream = getInputStream(fileName);
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }

    private static InputStream getInputStream(String fileName) throws FileNotFoundException {
        String appRoot = System.getProperty("CSV_FILE_PATH");
        InputStream is = null;
        if (appRoot!= null){
            is = getInputStream(appRoot,fileName);
            if(is==null)is=getInputStream(appRoot,fileName);
        }

        if(is==null){
            ClassLoader tcl;
            tcl=Thread.currentThread().getContextClassLoader();
            is=tcl.getResourceAsStream(fileName);
        }
        if(is==null)is=getInputStream("",fileName);
        if(is==null)throw new FileNotFoundException("File:'"+fileName+" not found in either system property:"+ appRoot+" or classpaths");
        return is;
    }

    private static InputStream getInputStream(String dir,String fileName){
        String absPath=null;
        if(dir !=null && dir.length()>0){
            String sep=(dir.endsWith("/")||dir.endsWith("\\"))?"":"/";
            absPath=dir+sep+fileName;
        }else{
            absPath=fileName;
        }

        File file=new File(absPath);
        if(!file.exists()){
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}