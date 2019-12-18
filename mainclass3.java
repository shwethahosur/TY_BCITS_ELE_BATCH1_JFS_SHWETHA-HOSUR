package p11;
import java.util.*;
public class mainclass3 {
public static void main(String[] args) {
	mobile m1=new mobile(2000,"samsung");
	mobile m2=new mobile(15000,"mi");
	mobile m3=new mobile(1000,"nokia");
	TreeSet<mobile> t=new TreeSet<mobile>();
	t.add(m1);
	t.add(m2);
	t.add(m3);
	for( mobile mo:t) {
		System.out.println(mo);
	}
}
}
