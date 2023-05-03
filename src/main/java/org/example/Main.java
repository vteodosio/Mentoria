package org.example;
import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Main {
    public static void main(String[] args) {
        try{
            utilizandoArquivos();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void utilizandoArquivos () throws IOException{
        //Obtendo o arquivo
        File arquivo = FileUtils.getFile("lero-lero.txt");

        //Obtendo o diretório temporário
        File dirTmp = FileUtils.getTempDirectory();
        System.out.println("########obtive o diretório#######");
        System.out.println(System.currentTimeMillis());

        //Printando o diretório
        System.out.println(((File) dirTmp).getName());

        //Copiando o arquivo à um diretório temporário
        FileUtils.copyFileToDirectory(arquivo, dirTmp);
        System.out.println("########copiei o arquivo ao dir temporario#########");
        System.out.println(System.currentTimeMillis());

        //Criando um novo arquivo
        File novoArqTemp = FileUtils.getFile(dirTmp, arquivo.getName());
        System.out.println("#######criei o arquivo novo#######");
        System.out.println(System.currentTimeMillis());

        //Copiando o conteúdo do arquivo
        String conteudo = FileUtils.readFileToString(novoArqTemp, "UTF-8");
        System.out.println("########peguei o conteudo do arquivo########");
        System.out.println(System.currentTimeMillis());

        //Printando o conteúdo do arquivo
        System.out.println(System.currentTimeMillis());
        System.out.println(conteudo);
        System.out.println(System.currentTimeMillis());
    }
}
