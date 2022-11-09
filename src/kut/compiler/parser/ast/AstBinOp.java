package kut.compiler.parser.ast;


import kut.compiler.compiler.CodeGenerator;
import kut.compiler.lexer.Token;

public class AstBinOp extends AstNode 
{
	/**
	 * 
	 */
	protected Token t;
	
	protected AstNode	lhs;
	protected AstNode	rhs;
	
	/**
	 * @param t
	 */
	public AstBinOp(AstNode lhs, AstNode rhs, Token t)
	{
		this.lhs = lhs;
		this.rhs = rhs;
		this.t = t;
	}

	/**
	 *
	 */
	@Override
	public void cgen(CodeGenerator gen)
	{	
		lhs.cgen(gen);
		gen.printCode("push rax");
		rhs.cgen(gen);
		
		if (t.getC() == '+') {
			gen.printCode("add rax, [rsp]");
			gen.printCode("add rsp, 8");
		}
		else if (t.getC() == '-') {
			gen.printCode("mov rbx, rax");
			gen.printCode("pop rax");
			gen.printCode("sub rax, rbx");
		}
		
		return;
	}
	

}
