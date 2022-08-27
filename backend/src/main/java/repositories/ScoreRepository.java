package repositories;

import entities.Score;

public interface ScoreRepository {

	Score saveAndFlush(Score score);

}
