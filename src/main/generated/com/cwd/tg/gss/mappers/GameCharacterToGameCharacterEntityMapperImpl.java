package com.cwd.tg.gss.mappers;

import com.cwd.tg.gss.data.character.CharacterProgress;
import com.cwd.tg.gss.data.character.CharacterStats;
import com.cwd.tg.gss.data.character.EquipmentItem;
import com.cwd.tg.gss.data.character.EquipmentSlot;
import com.cwd.tg.gss.data.character.GameCharacter;
import com.cwd.tg.gss.data.character.GameInventory;
import com.cwd.tg.gss.entities.CharacterProgressInfo;
import com.cwd.tg.gss.entities.CharacterStatsData;
import com.cwd.tg.gss.entities.GameCharacterEntity;
import com.cwd.tg.gss.entities.GameInventoryData;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-11T15:26:54+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class GameCharacterToGameCharacterEntityMapperImpl implements GameCharacterToGameCharacterEntityMapper {

    @Override
    public GameCharacterEntity convert(GameCharacter source) {
        if ( source == null ) {
            return null;
        }

        GameCharacterEntity gameCharacterEntity = new GameCharacterEntity();

        gameCharacterEntity.setId( source.getId() );
        gameCharacterEntity.setName( source.getName() );
        gameCharacterEntity.setInAdventure( source.isInAdventure() );
        gameCharacterEntity.setFighting( source.isFighting() );
        gameCharacterEntity.setResting( source.isResting() );
        gameCharacterEntity.setCurrentAction( source.getCurrentAction() );
        gameCharacterEntity.setProgress( characterProgressToCharacterProgressInfo( source.getProgress() ) );
        gameCharacterEntity.setStats( characterStatsToCharacterStatsData( source.getStats() ) );
        gameCharacterEntity.setGameInventory( gameInventoryToGameInventoryData( source.getGameInventory() ) );
        gameCharacterEntity.setUserId( source.getUserId() );
        gameCharacterEntity.setCreatedAt( source.getCreatedAt() );
        gameCharacterEntity.setLastModifiedAt( source.getLastModifiedAt() );

        return gameCharacterEntity;
    }

    protected CharacterProgressInfo characterProgressToCharacterProgressInfo(CharacterProgress characterProgress) {
        if ( characterProgress == null ) {
            return null;
        }

        CharacterProgressInfo characterProgressInfo = new CharacterProgressInfo();

        characterProgressInfo.setCurrentExp( characterProgress.getCurrentExp() );
        characterProgressInfo.setLevel( characterProgress.getLevel() );
        characterProgressInfo.setTargetExp( characterProgress.getTargetExp() );

        return characterProgressInfo;
    }

    protected CharacterStatsData characterStatsToCharacterStatsData(CharacterStats characterStats) {
        if ( characterStats == null ) {
            return null;
        }

        CharacterStatsData characterStatsData = new CharacterStatsData();

        characterStatsData.setPower( characterStats.getPower() );
        characterStatsData.setAgility( characterStats.getAgility() );
        characterStatsData.setIntelligence( characterStats.getIntelligence() );
        characterStatsData.setHitPoints( characterStats.getHitPoints() );
        characterStatsData.setManaPoints( characterStats.getManaPoints() );
        characterStatsData.setAttack( characterStats.getAttack() );

        return characterStatsData;
    }

    protected Map<String, EquipmentItem> equipmentSlotEquipmentItemMapToStringEquipmentItemMap(Map<EquipmentSlot, EquipmentItem> map) {
        if ( map == null ) {
            return null;
        }

        Map<String, EquipmentItem> map1 = new HashMap<String, EquipmentItem>( Math.max( (int) ( map.size() / .75f ) + 1, 16 ) );

        for ( java.util.Map.Entry<EquipmentSlot, EquipmentItem> entry : map.entrySet() ) {
            String key = entry.getKey().name();
            EquipmentItem value = entry.getValue();
            map1.put( key, value );
        }

        return map1;
    }

    protected GameInventoryData gameInventoryToGameInventoryData(GameInventory gameInventory) {
        if ( gameInventory == null ) {
            return null;
        }

        GameInventoryData gameInventoryData = new GameInventoryData();

        gameInventoryData.setGold( gameInventory.getGold() );
        gameInventoryData.setHealingHitPointItems( gameInventory.getHealingHitPointItems() );
        gameInventoryData.setHealingManaPointItems( gameInventory.getHealingManaPointItems() );
        gameInventoryData.setEquipment( equipmentSlotEquipmentItemMapToStringEquipmentItemMap( gameInventory.getEquipment() ) );

        return gameInventoryData;
    }
}
