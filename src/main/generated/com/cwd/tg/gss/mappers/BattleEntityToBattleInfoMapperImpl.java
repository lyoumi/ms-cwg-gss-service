package com.cwd.tg.gss.mappers;

import com.cwd.tg.gss.data.events.battle.BattleInfo;
import com.cwd.tg.gss.entities.BattleEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-11T15:26:53+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class BattleEntityToBattleInfoMapperImpl implements BattleEntityToBattleInfoMapper {

    @Override
    public BattleInfo convert(BattleEntity source) {
        if ( source == null ) {
            return null;
        }

        BattleInfo battleInfo = new BattleInfo();

        battleInfo.setId( source.getId() );
        battleInfo.setCharacterId( source.getCharacterId() );
        battleInfo.setMonsterId( source.getMonsterId() );
        battleInfo.setAwardsId( source.getAwardsId() );

        return battleInfo;
    }
}
