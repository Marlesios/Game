import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> game = new ArrayList<>();
        List<File> files =new ArrayList<>();


        //Главный директорий
        File Games = new File("E://Games1");
        //под директории в главный
        File src = new File("E://Games1/src");
        File res = new File("E://Games1/res");
        File savegames = new File("E://Games1/savegames");
        File temp = new File("E://Games1/temp");

        //директории в папку src
        File main = new File(src,"main");
        File test = new File(src,"test");

        //Файлы в папку /games/src/main
        File Main_java = new File(main,"Main.java");
        File Java_utils = new File(main,"Utils.java");

        //Файлы в /Games/res
        File drawables = new File(res,"drawables");
        File vectors = new File(res,"vectors");
        File icons = new File(res,"icons");

        //temp.txt для сохранений логов
        File temp_txt = new File(temp,"temp.txt");

        game.add(Games);
        game.add(src);
        game.add(res);
        game.add(savegames);
        game.add(temp);

        //добавляем в src
        game.add(main);
        game.add(test);

        //добавляем в папку /games/src/main
        files.add(Main_java);
        files.add(Java_utils);

        //добавляем в /Games/res
        game.add(drawables);
        game.add(vectors);
        game.add(icons);

        //temp.txt
        files.add(temp_txt);

                 //цикл для добавления директорий
                for(File file: game){
                    //makeDirectory(file);
                   sb.append(makeDirectory(file));
                }
                //цикл для добавлений файлов
                for(File file: files){
                   // makeFile(file);
                    sb.append(makeFile(file));
                }

            // добавляем все логи в записную книгу temp.txt
            String one = sb.toString();
            byte[] buffer = one.getBytes();
            try(FileOutputStream writer = new FileOutputStream(temp_txt);
                 BufferedOutputStream bos = new BufferedOutputStream(writer)) {
                    bos.write(buffer,0,buffer.length);
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
    }
    public static String makeDirectory(File file) {
        if (!file.exists()) {
            if (file.mkdir()) {
                return "Файл " + file.getName() + " создан \n";
            } else {
                System.out.println("не получилось");
            }
        }return null;
    }
    public static String makeFile(File file){
        try{
            if(file.createNewFile())
                return "Файл " + file.getName() + " создан \n";

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }return null;
    }
}
