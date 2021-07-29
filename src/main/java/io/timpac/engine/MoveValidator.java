package io.timpac.engine;

import io.timpac.gui.Position;
import io.timpac.util.Uiutils;

public class MoveValidator {

	public static boolean outOfBoundary(Position position) {
		return position.getX() < 1 || position.getX() > Uiutils.TILE_COLUMN_NUM
				|| position.getY() < 1 && position.getY() > Uiutils.TILE_ROW_NUM;
	}

}
