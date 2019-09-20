package others.公司笔试题;
public class 乌鸦喝水 {
	public static void main(String[] args) {
		getRes(2);
	}
	
	public static void getRes(int n) {
		int fenZi = 1;
		int fenMu = 1;
		for (int i = 1; i < n; i++) {
			fenZi = 1 + fenZi << 1 ;
			fenMu = fenMu << 1;
		}
		huaJian(fenZi,fenMu);
	}
	
	public static void huaJian(int m,int n) {
		int a = m , b = n;
		int t = m%n;
        while(t!=0){
            m=n;
            n=t;
            t=m%n;
        }
        if(t== 0 ) System.out.println(a+"/"+b);
        else System.out.println(m/t+"/"+n/t);
  
	}
}
