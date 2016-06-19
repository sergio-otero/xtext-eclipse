/*
 * generated by Xtext
 */
package org.eclipse.xtext.grammarinheritance.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.grammarinheritance.services.InheritanceTest3LanguageGrammarAccess;

public class InheritanceTest3LanguageParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private InheritanceTest3LanguageGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.xtext.grammarinheritance.parser.antlr.internal.InternalInheritanceTest3LanguageParser createParser(XtextTokenStream stream) {
		return new org.eclipse.xtext.grammarinheritance.parser.antlr.internal.InternalInheritanceTest3LanguageParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}
	
	public InheritanceTest3LanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(InheritanceTest3LanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}