package com.cwd.tg.gss.mappers;

import com.cwd.tg.gss.data.events.battle.Monster;
import com.cwd.tg.gss.data.events.battle.MonsterType;
import com.cwd.tg.gss.entities.MonsterEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-11T15:26:53+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class MonsterEntityToMonsterMapperImpl implements MonsterEntityToMonsterMapper {

    @Override
    public Monster convert(MonsterEntity source) {
        if ( source == null ) {
            return null;
        }

        Monster monster = new Monster();

        monster.setId( source.getId() );
        monster.setHitPoints( source.getHitPoints() );
        monster.setAttack( source.getAttack() );
        if ( source.getMonsterType() != null ) {
            monster.setMonsterType( Enum.valueOf( MonsterType.class, source.getMonsterType() ) );
        }
        monster.setCreatedAt( source.getCreatedAt() );
        monster.setLastModifiedAt( source.getLastModifiedAt() );

        return monster;
    }
}
