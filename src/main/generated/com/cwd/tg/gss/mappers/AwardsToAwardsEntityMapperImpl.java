package com.cwd.tg.gss.mappers;

import com.cwd.tg.gss.data.events.awards.Awards;
import com.cwd.tg.gss.entities.AwardsEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-11T15:26:54+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class AwardsToAwardsEntityMapperImpl implements AwardsToAwardsEntityMapper {

    @Override
    public AwardsEntity convert(Awards source) {
        if ( source == null ) {
            return null;
        }

        AwardsEntity awardsEntity = new AwardsEntity();

        awardsEntity.setId( source.getId() );
        awardsEntity.setExperience( source.getExperience() );
        awardsEntity.setGold( source.getGold() );

        return awardsEntity;
    }
}
