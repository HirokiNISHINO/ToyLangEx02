package kut.compiler.parser.ast;


import kut.compiler.compiler.CodeGenerator;

/**
 * @author hnishino
 *
 */
public abstract class AstNode {
	
	
		/**
		 * @return the generated code string
		 */
		public abstract void cgen(CodeGenerator gen);
		



}
