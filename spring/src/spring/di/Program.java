package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsle;
import spring.di.ui.InlineExamConsle;

public class Program {

	public static void main(String[] args) {
	 
		/* 스프링에게 지시하는 방법으로 코드로 변경
		 * Exam exam = new NewlecExam(); 
		 * ExamConsole console = new GridExamConsle(exam);
		 * 
		 * 
		 * console.setExam(exam);
		 * 
		 * 
		 */
		
		
		
		ExamConsole console = ?;
		console.print();
	}

}
