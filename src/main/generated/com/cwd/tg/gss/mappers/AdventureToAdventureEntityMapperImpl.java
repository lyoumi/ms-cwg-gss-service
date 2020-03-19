package com.cwd.tg.gss.mappers;

import com.cwd.tg.gss.data.events.adventure.Adventure;
import com.cwd.tg.gss.entities.AdventureEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-11T15:26:54+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class AdventureToAdventureEntityMapperImpl implements AdventureToAdventureEntityMapper {

    @Override
    public AdventureEntity convert(Adventure source) {
        if ( source == null ) {
            return null;
        }

        AdventureEntity adventureEntity = new AdventureEntity();

        adventureEntity.setId( source.getId() );
        adventureEntity.setCharacterId( source.getCharacterId() );
        adventureEntity.setDescription( source.getDescription() );
        adventureEntity.setAwardsId( source.getAwardsId() );
        if ( source.getStatus() != null ) {
            adventureEntity.setStatus( source.getStatus().name() );
        }
        List<String> list = source.getAdventureEvents();
        if ( list != null ) {
            adventureEntity.setAdventureEvents( new ArrayList<String>( list ) );
        }
        adventureEntity.setStep( source.getStep() );
        adventureEntity.setCreatedAt( source.getCreatedAt() );
        adventureEntity.setLastModifiedAt( source.getLastModifiedAt() );

        return adventureEntity;
    }
}
