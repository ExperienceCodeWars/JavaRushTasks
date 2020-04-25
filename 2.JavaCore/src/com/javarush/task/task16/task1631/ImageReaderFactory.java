package com.javarush.task.task16.task1631;
import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type){
    // ImageReader toReturn = null;
    // switch(type){
    //       case BMP:
    //           toReturn = new BmpReader();
    //           break;
    //       case JPG:
    //           toReturn = new JpgReader();
    //           break;
    //       case PNG:
    //           toReturn = new PngReader();
    //           break;
    //       default:
    //           throw new IllegalArgumentException("Неизвестный тип картинки");
              
    //     }
    //     return toReturn;
    if (type == ImageTypes.JPG) {return  new JpgReader();}
        if (type == ImageTypes.BMP) {return  new BmpReader();}
        if (type == ImageTypes.PNG) {return  new PngReader();}
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}