package com.example.swagger.reptile.service.impl;

import com.example.swagger.common.utils.DateUtil;
import com.example.swagger.reptile.service.ReptileService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.*;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
@Service
public class ReptileServiceImpl implements ReptileService {
    @Override
    public  List<String> getImg(String imgUrl) throws IOException {

        URL url = new URL(imgUrl);
        BufferedReader bfReed = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder buff = new StringBuilder();

        while (bfReed.readLine() != null) {
            buff.append(bfReed.readLine());
        }

        //解析html
        Document parse = Jsoup.parse(buff.toString());
        Elements img = parse.getElementsByTag("img");

        List<String> imgList = new ArrayList<>();

        for (Element element : img) {

            String imgSrc = element.attr("src2");

            // 判断imgSrc是否为空且是否以"http://"开头
            if (!"".equals(imgSrc) && (imgSrc.startsWith("http://") || imgSrc.startsWith("https://"))) {
                imgList.add(imgSrc);
            }
        }

        saveImgFile(imgList);

        return imgList;
    }

    @Override
    public void saveImgFile(List<String> imgList) throws IOException {
        for (String imgUrl : imgList) {

            URL url=new URL(imgUrl);
            InputStream in = url.openStream();
            BufferedInputStream bfIn=new BufferedInputStream(in);

            String property = System.getProperty("user.dir");
            File file = new File(property + "\\src\\main\\resources\\img\\"+ DateUtil.dateToString(new Date(),DateUtil.DATE_FORMAT_YYYYMMDD));
            OutputStream out=new FileOutputStream(file);
            BufferedOutputStream bfOut=new BufferedOutputStream(out);

            byte[] bytes=new byte[1024];
            int len;
            while ((len=bfIn.read(bytes))!=-1){
                bfOut.write(bytes,0,len);
            }
        }

    }


    public static void main(String[] args) throws IOException {
        URL url = new URL("http://sc.chinaz.com/tupian/beijingtupian.html");
        BufferedReader bfReed = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder buff = new StringBuilder();

        while (bfReed.readLine() != null) {
            buff.append(bfReed.readLine());
        }

        //解析html
        Document parse = Jsoup.parse(buff.toString());
        Elements img = parse.getElementsByTag("img");

        List<String> imgList = new ArrayList<>();


        for (Element element : img) {

            String imgSrc = element.attr("src2");

            // 判断imgSrc是否为空且是否以"http://"开头
            if (!"".equals(imgSrc) && (imgSrc.startsWith("http://") || imgSrc.startsWith("https://"))) {
                imgList.add(imgSrc);
            }
        }

        for (String imgUrl : imgList) {

            URL urls=new URL(imgUrl);
            InputStream in = urls.openStream();
            BufferedInputStream bfIn=new BufferedInputStream(in);

            String property = System.getProperty("user.dir");
            File file = new File(property + "\\src\\main\\resources\\img\\"+ DateUtil.dateToString(new Date(),DateUtil.DATE_FORMAT_YYYYMMDD));
            if(!file.exists()){//如果文件夹不存在
                file.mkdir();//创建文件夹
            }

            String substring = imgUrl.substring(imgUrl.length() - 10);
            String[] split = substring.split("\\.");



            OutputStream out=new FileOutputStream(new File(property + "\\src\\main\\resources\\img\\"+
                    DateUtil.dateToString(new Date(),DateUtil.DATE_FORMAT_YYYYMMDD)+"\\"+split[0]+".jpg"));
            BufferedOutputStream bfOut=new BufferedOutputStream(out);

            byte[] bytes=new byte[102400];
            int len;
            while ((len=bfIn.read(bytes))!=-1){
                bfOut.write(bytes,0,len);
            }
        }
    }


}
