package sword.烦人题;

/**
 * 判断字符串是否表示数值
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 1.e只能出现一次，而且不能是最后一个字符
 * 2. +，-号可以出现两次，第一次出现如果不是在开头，后面必须是e；第二次出现，后面一定是e
 * 3.小数点只能出现一次，而且出现e之后不能出现小数点
 * 4.除了以上三种字符，只能是0-9之间的字符。
 * @author yuyang
 * @create 2019-08-07 10:36
 */
public class d表示数值的字符串 {
        public boolean isNumeric(char[] str) {
            boolean sign = false, decimal = false, hasE = false;
            for(int i = 0; i < str.length; i++){
                if(str[i] == 'e' || str[i] == 'E'){
                    if(i == str.length - 1) return false; //e后面一定有数字
                    if(hasE) return false;//不能出现两个e
                    hasE = true;
                }else if(str[i] == '+' || str[i] == '-'){
                    //第二次出现+-符号，则必须紧接在e之后
                    if(sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                    // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                    if(!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                    sign = true;
                }else if(str[i] == '.'){
                    // e后面不能接小数点，小数点不能出现两次
                    if(hasE || decimal) return false;
                    decimal = true;
                }else if(str[i] < '0' || str[i] > '9')//不合法字符
                    return false;
            }
            return true;
        }
    }
