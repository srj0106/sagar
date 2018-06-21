package com.interview.programs;

import java.util.ArrayList;

public class ReplaceCharachter {

	public static void main(String[] args) {
		char[] str = {'h','e','l','l','o','e','e','l','a','a'};
		char[] find = {'l','l','o'};
		char[] replace = {'e'};
		int find_len = find.length;
		int rep_len = replace.length;
		int flag = 0;
		int f = 0;
		int[] index = new int[20];
		int i_a = 1;
		index[0] = 0;
		int j =1;
		ArrayList<Character> final_word = new ArrayList<Character>();
		for(int i=0; i<str.length; i++){
			if(flag == 1 && f<find_len && str[i] != find[f]){
				flag = 0;
				f = 0;
			}
			if(str[i] == find[f] && f<find_len){
				flag = 1;
				f++;
			}
			
			if(f==find_len && flag == 1){
				index[i_a] = i - find_len +1;
				i_a++;
				f = 0;
				flag = 0;
			}
		}
		while(j<i_a && j<20)
		{
			if(j == i_a - 1 && j == 1){
				for (int i=0; i<index[j]; i++){
					final_word.add(str[i]);
				}
				for (int i=0; i<rep_len; i++){
					final_word.add(replace[i]);
				}
				for (int i=index[j]+find_len; i<str.length ; i++ ){
					final_word.add(str[i]);
				}
			}
			else if(j == i_a - 1)
			{
				for (int i=index[j-1] + find_len; i<index[j] ; i++ ){
					final_word.add(str[i]);
				}
				for (int i=0; i<rep_len; i++){
					final_word.add(replace[i]);
				}
				for (int i=index[j] + find_len; i<str.length ; i++ ){
					final_word.add(str[i]);
				}
			}
			else if (j == 1)
			{
				for (int i=0; i<index[j]; i++){
					final_word.add(str[i]);
				}
				for (int i=0; i<rep_len; i++){
					final_word.add(replace[i]);
				}
			}
			else
			{
				for (int i=index[j-1] + find_len; i<index[j] ; i++ ){
					final_word.add(str[i]);
				}
				for (int i=0; i<rep_len; i++){
					final_word.add(replace[i]);
				}
			}
			j++;
		}
		System.out.println(final_word);
	}

}
