/*******************************************************************************
 * Copyright (c) 2014, Paul Weingardt
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Paul Weingardt - initial API and implementation
 *******************************************************************************/



package de.weingardt.mylyn.gitlab.ui;

import org.eclipse.mylyn.commons.ui.CommonImages;
import org.eclipse.mylyn.tasks.ui.ITasksUiConstants;
import org.eclipse.mylyn.tasks.ui.TasksUiImages;
import org.eclipse.mylyn.tasks.ui.TasksUiUtil;
import org.eclipse.mylyn.tasks.ui.editors.AbstractTaskEditorPageFactory;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditor;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditorInput;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.forms.editor.IFormPage;

import de.weingardt.mylyn.gitlab.core.GitlabPluginCore;

public class GitlabEditorPageFactory extends AbstractTaskEditorPageFactory {

	@Override
	public boolean canCreatePageFor(TaskEditorInput input) {
		if (input.getTask().getConnectorKind().equals(GitlabPluginCore.CONNECTOR_KIND)) {
			return true;
		} else if (TasksUiUtil.isOutgoingNewTask(input.getTask(), GitlabPluginCore.CONNECTOR_KIND)) {
			return true;
		}
		return false;
	}

	@Override
	public IFormPage createPage(TaskEditor editor) {
		return new GitlabEditorPage(editor, GitlabPluginCore.CONNECTOR_KIND);
	}

	@Override
	public Image getPageImage() {
		return CommonImages.getImage(TasksUiImages.TASK);
	}

	@Override
	public String getPageText() {
		return Strings.GITLAB_ISSUE;
	}
	
	@Override
	public String[] getConflictingIds(TaskEditorInput input) {
		return new String[] {ITasksUiConstants.ID_PAGE_PLANNING};
	}

}
