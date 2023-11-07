import java.util.*;
import java.io.*;
import java.util.Scanner;
public class lz77algorithim {
    ArrayList <tages>MyTags = new ArrayList<tages>();
    tages newTage;
    int pointer_search_windo,look_head_windo;
    public void compression(String code){
        for(int i=0;i<code.length();i++){
            int position=0,length=0;
            if(i==0){
                //compressionCode+=position+length+code[i];
                newTage = new tages(position,length,code.charAt(i));
                MyTags.add(newTage);
            }
            else{
                pointer_search_windo=i-1;
                look_head_windo=i+1;
                int catchpointer=-1;
                while(pointer_search_windo>=0){
                    if(code.charAt(i)==code.charAt(pointer_search_windo)){
                        catchpointer=pointer_search_windo;
                        break;
                    }
                    pointer_search_windo--;
                }
                if(catchpointer==-1){
                    newTage = new tages(position,length,code.charAt(i));
                    MyTags.add(newTage);
                }
                else{
                    int s=catchpointer+1;
                    while(s<=i&&look_head_windo<=code.length()){
                        if(code.charAt(s)!=code.charAt(look_head_windo))
                        {
                            position=(i-pointer_search_windo);
                            length=(look_head_windo-i);
                            newTage = new tages(position,length,code.charAt(i+1));
                            MyTags.add(newTage);
                            i++;
                            break;
                        }
                        else{
                            s++;
                            look_head_windo++;
                        }
                    }
                }
            }
            System.out.print("<"+newTage +"> ");
        }

    }
    public void decompression(ArrayList <tages>MyTag){
        String s="";
        for(int i=0;i<MyTag.size();i++)
        {
            if(MyTag.get(i).position == 0 && MyTag.get(i).length == 0)
            {
                s+= MyTag.get(i).nextChar;
            }
            else
            {
                int cnt = Math.abs(MyTag.get(i).position-s.length());
                for(int j=cnt ;j<cnt+MyTag.get(i).length;j++)
                {
                    s+= s.charAt(j);
                }
                s+=MyTag.get(i).nextChar;
            }
        }
        System.out.println(s);
    }
}
class tages{

    int position;
    int length;
    char nextChar;

    //Constructor
    tages(int position,int length,char nextChar){
        this.position = position;
        this.length = length;
        this.nextChar = nextChar;
    }
    public String toString(){
        return position + "," + length + "," + nextChar;
    }
}
