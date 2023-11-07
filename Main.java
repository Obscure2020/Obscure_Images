import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

class Main{
    public static void main(String[] args) throws Exception{
        PrintWriter pw = new PrintWriter(new FileOutputStream("README.md"), true, StandardCharsets.UTF_8);
        pw.println("# Obscure Images");
        pw.println();
        pw.println("I created this repo in November of 2023, shortly after recieving word that Discord would begin limiting the lifetime of its CDN links to 24 hours.");
        pw.println();
        pw.println("This repo exists for no other purpose than to contain files which I wish to make publicly accessible online, with stable links to their raw forms.");
        pw.println();
        {
            pw.println("### Opus Magnum GIFs");
            File opusGifDir = new File("Opus_Magnum_GIFs");
            TreeMap<String, String> fileMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            for(File f : opusGifDir.listFiles()){
                String cleanName = f.getName().replace('_', ' ');
                cleanName = cleanName.substring(0, cleanName.lastIndexOf('.'));
                String url = "https://cdn.jsdelivr.net/gh/Obscure2020/Obscure_Images/Opus_Magnum_GIFs/" + f.getName();
                fileMap.put(cleanName, url);
            }
            for(Map.Entry<String, String> item : fileMap.entrySet()){
                pw.print("- [");
                pw.print(item.getKey());
                pw.print("](");
                pw.print(item.getValue());
                pw.println(')');
            }
        }
        pw.close();
    }
}