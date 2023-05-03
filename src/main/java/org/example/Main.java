package org.example;
import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.pattern.LogEvent;

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

         final Logger logger = LogManager.getLogger(Main.class);


        //System.out.println("########obtive o diretório#######");
        //System.out.println(System.currentTimeMillis());
        logger.info("########obtive o diretório#######");
        logger.debug((System.currentTimeMillis()));

        //Printando o diretório
        //System.out.println(((File) dirTmp).getName());
        logger.debug(((File) dirTmp).getName());

        //Copiando o arquivo à um diretório temporário
        FileUtils.copyFileToDirectory(arquivo, dirTmp);

        logger.info("########copiei o arquivo ao dir temporario#########");
        logger.debug(System.currentTimeMillis());
        //System.out.println("########copiei o arquivo ao dir temporario#########");
        //System.out.println(System.currentTimeMillis());

        //Criando um novo arquivo
        File novoArqTemp = FileUtils.getFile(dirTmp, arquivo.getName());
        logger.info("#######criei o arquivo novo#######");
        logger.debug(System.currentTimeMillis());
        //System.out.println("#######criei o arquivo novo#######");
        //System.out.println(System.currentTimeMillis());

        //Copiando o conteúdo do arquivo
        String conteudo = FileUtils.readFileToString(novoArqTemp, "UTF-8");
        logger.info("########peguei o conteudo do arquivo########");
        logger.debug(System.currentTimeMillis());
        //System.out.println("########peguei o conteudo do arquivo########");
        //System.out.println(System.currentTimeMillis());

        //Printando o conteúdo do arquivo
        logger.debug(System.currentTimeMillis());
        logger.debug(conteudo);
        logger.debug(System.currentTimeMillis());
        //System.out.println(System.currentTimeMillis());
        //System.out.println(conteudo);
        //System.out.println(System.currentTimeMillis());

        // next steps
        //1- contar quantas palavras tem no arquivo
        //2- fazer uma contagem (relatorio) da quantidade de repetição de cada letra
        //3- remover todos os caracteres especiais e salvar sem estes caracteres (utilizar algo do apache commons util)

    }
}
