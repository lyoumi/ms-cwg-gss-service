package com.cwd.tg.gss.mappers;

import com.cwd.tg.gss.data.events.adventure.Adventure;
import com.cwd.tg.gss.data.events.adventure.AdventureStatus;
import com.cwd.tg.gss.entities.AdventureEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-11T15:26:54+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class AdventureEntityToAdventureMapperImpl implements AdventureEntityToAdventureMapper {

    @Override
    public Adventure convert(AdventureEntity source) {
        if ( source == null ) {
            return null;
        }

        Adventure adventure = new Adventure();

        adventure.setId( source.getId() );
        adventure.setCharacterId( source.getCharacterId() );
        adventure.setDescription( source.getDescription() );
        adventure.setAwardsId( source.getAwardsId() );
        if ( source.getStatus() != null ) {
            adventure.setStatus( Enum.valueOf( AdventureStatus.class, source.getStatus() ) );
        }
        List<String> list = source.getAdventureEvents();
        if ( list != null ) {
            adventure.setAdventureEvents( new ArrayList<String>( list ) );
        }
        adventure.setStep( source.getStep() );
        adventure.setCreatedAt( source.getCreatedAt() );
        adventure.setLastModifiedAt( source.getLastModifiedAt() );

        return adventure;
    }
}
