package org.example;
import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.pattern.LogEvent;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    static final int MAX_CHAR = 512;
    public static void main(String[] args){
        //Contador de palavras
        try{
            //contandoPalavras();
            //contandoCaracteres();
            relatorioCaracteres();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

       /* try{
            utilizandoArquivos();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }*/
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
    }

    public static void contandoPalavras() throws IOException {
        final Logger logger = LogManager.getLogger(Main.class);

        /* Bloco de contagem da quantidade de palavras no arquivo*/

        String line;
        int count = 0;

        FileReader arquivo = new FileReader("lero-lero.txt");
        BufferedReader br = new BufferedReader(arquivo);
        while ((line = br.readLine()) != null){
            String words[] = line.split(" ");
            count = count + words.length;
        }

        logger.debug("Número de palavras no arquivo: ");
        logger.debug(count);
    }

    public static void contandoCaracteres() throws IOException{
        final Logger logger = LogManager.getLogger(Main.class);

        String data;
        int count = 0;

        FileReader arquivo1 = new FileReader("lero-lero.txt");
        BufferedReader br1 = new BufferedReader(arquivo1);

        while ((data = br1.readLine()) != null){
            count += data.length();
        }
        logger.debug("Número de letras no arquivo: ");
        logger.debug(count);
    }

    public static void relatorioCaracteres() throws IOException{
        final Logger logger = LogManager.getLogger(Main.class);

        FileReader arquivo1 = new FileReader("lero-lero.txt");
        BufferedReader br1 = new BufferedReader(arquivo1);
        String data = br1.toString();


        int count[] = new int[MAX_CHAR];
        int len = data.length();

        for (int i = 0; i < len; i++){
            count[data.charAt(i)]++;
        }

        char ch[] = new char[data.length()];
        for (int i = 0; i < len; i++)
        {
            ch[i] = data.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++)
            {
//if any matches found
                if (data.charAt(i) == ch[j])
                    find++;
            }
            if (find == 1)
//prints occurrence of the character
                System.out.println("The occurrence of "+ data.charAt(i)+ " is: " + count[data.charAt(i)]);
        }
    }
}

// next steps
//1- contar quantas palavras tem no arquivo - done
//2- fazer uma contagem (relatorio) da quantidade de repetição de cada letra
//3- remover todos os caracteres especiais e salvar sem estes caracteres (utilizar algo do apache commons util)

