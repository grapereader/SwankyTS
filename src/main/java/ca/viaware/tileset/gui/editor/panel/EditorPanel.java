/*
Copyright 2014 Seth Traverse

This file is part of Project Sierra.

Project Sierra is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Project Sierra is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Project Sierra.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.viaware.tileset.gui.editor.panel;

import ca.viaware.tileset.obj.Tileset;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class EditorPanel extends JPanel {

    private Tileset tileset;

    private EditorSidebarPanel sidebarPanel;
    private EditorGraphicsPanel editor;

    public EditorPanel(Tileset tileset) {
        this.tileset = tileset;

        this.editor = new EditorGraphicsPanel(tileset);
        this.sidebarPanel = new EditorSidebarPanel(tileset, editor);

        final JScrollPane scroll = new JScrollPane(editor);

        scroll.getViewport().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                //Linux fix
                scroll.repaint();
            }
        });

        setLayout(new BorderLayout());
        add(sidebarPanel, BorderLayout.LINE_START);
        add(scroll, BorderLayout.CENTER);
    }

}
