package com.dell.glit.util;

import java.io.Serializable;

import com.dell.glit.model.Questionaire;

public class QuestionaireDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2142593425562571662L;
	private Questionaire questionaire;
	private boolean questionaireHasInteraction;
	
	public Questionaire getQuestionaire() {
		return questionaire;
	}
	public void setQuestionaire(Questionaire questionaire) {
		this.questionaire = questionaire;
	}
	public boolean getQuestionaireHasInteraction() {
		return questionaireHasInteraction;
	}
	public void setQuestionaireHasInteraction(boolean isQuestionaireHasInteraction) {
		this.questionaireHasInteraction = isQuestionaireHasInteraction;
	}
}
