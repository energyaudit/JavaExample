package util;

import static util.removeLineBreaks.removeLbr;


public class removeLineBreakArray {
    public static String[] removeLineBrArray(String[] arrayin){
        for(int i=0;i<arrayin.length;i++){
            removeLbr(arrayin[i]);
        }
        return arrayin;
    }
    public static void main(String[] args) {
        String[] text ={"abcdefghij \n nopq\n"
                ,"klmnopq\n ghij \n zzzz"} ;
        removeLineBrArray(text);
    }
}
