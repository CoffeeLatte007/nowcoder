package jianzhioffer;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * Created by lizhaoz on 2016/3/11.
 */

public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str==null||str.length()<=0){
            return "";
        }
        char[] s=str.toCharArray();
        reverse(s,0,s.length-1);
        int begin=0;int end=0;
        for (int i = 0; i < s.length; i++) {
            if (s[i]==' '){
                reverse(s,begin,end-1);
                begin=end+1;
                end++;
            }else {
                end++;
            }
        }
        reverse(s,begin,s.length-1);
        return String.valueOf(s);
    }
    private void reverse(char[] s,int begin,int end) {
        while (begin<end){
            char tmp=s[begin];
            s[begin]=s[end];
            s[end]=tmp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseSentence r=new ReverseSentence();
        System.out.println(r.ReverseSentence("I am a student."));
    }
}
