package com.cwd.tg.gss.mappers;

import com.cwd.tg.gss.data.events.battle.Monster;
import com.cwd.tg.gss.entities.MonsterEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-11T15:26:53+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class MonsterToMonsterEntityMapperImpl implements MonsterToMonsterEntityMapper {

    @Override
    public MonsterEntity convert(Monster source) {
        if ( source == null ) {
            return null;
        }

        MonsterEntity monsterEntity = new MonsterEntity();

        monsterEntity.setId( source.getId() );
        monsterEntity.setHitPoints( source.getHitPoints() );
        monsterEntity.setAttack( source.getAttack() );
        if ( source.getMonsterType() != null ) {
            monsterEntity.setMonsterType( source.getMonsterType().name() );
        }
        monsterEntity.setCreatedAt( source.getCreatedAt() );
        monsterEntity.setLastModifiedAt( source.getLastModifiedAt() );

        return monsterEntity;
    }
}
