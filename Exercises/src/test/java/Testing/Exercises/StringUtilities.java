package Testing.Exercises;

import java.util.HashSet;

public class StringUtilities {
		HashSet<Character> lower=new HashSet<>();
		HashSet<Character> upper=new HashSet<>();
		
		public StringUtilities()
		{
			lower.add('a');
			lower.add('e');
			lower.add('i');
			lower.add('o');
			lower.add('u');
			upper.add('A');
			upper.add('E');
			upper.add('I');
			upper.add('O');
			upper.add('U');
		}
		public int count(String s)
		{
			int c=0;
			if(s==null) return 0;
			for(int i=0;i<s.length();i++)
			{
				if(lower.contains(s.charAt(i)))
				{
					c++;
				}else if(upper.contains(s.charAt(i)))
				{
					c++;
				}
			}
			return c;
			
		}
		public boolean isCapital(String s)
		{
			if(s==null || s.length()==0) 
				return false;
			else return(upper.contains(s.charAt(0)));
			
		}
}
