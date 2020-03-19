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
    date = "2019-12-11T15:26:53+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class GameCharacterEntityToGameCharacterMapperImpl implements GameCharacterEntityToGameCharacterMapper {

    @Override
    public GameCharacter convert(GameCharacterEntity source) {
        if ( source == null ) {
            return null;
        }

        GameCharacter gameCharacter = new GameCharacter();

        gameCharacter.setId( source.getId() );
        gameCharacter.setName( source.getName() );
        gameCharacter.setInAdventure( source.isInAdventure() );
        gameCharacter.setFighting( source.isFighting() );
        gameCharacter.setResting( source.isResting() );
        gameCharacter.setCurrentAction( source.getCurrentAction() );
        gameCharacter.setProgress( characterProgressInfoToCharacterProgress( source.getProgress() ) );
        gameCharacter.setStats( characterStatsDataToCharacterStats( source.getStats() ) );
        gameCharacter.setGameInventory( gameInventoryDataToGameInventory( source.getGameInventory() ) );
        gameCharacter.setUserId( source.getUserId() );
        gameCharacter.setCreatedAt( source.getCreatedAt() );
        gameCharacter.setLastModifiedAt( source.getLastModifiedAt() );

        return gameCharacter;
    }

    protected CharacterProgress characterProgressInfoToCharacterProgress(CharacterProgressInfo characterProgressInfo) {
        if ( characterProgressInfo == null ) {
            return null;
        }

        CharacterProgress characterProgress = new CharacterProgress();

        characterProgress.setCurrentExp( characterProgressInfo.getCurrentExp() );
        characterProgress.setLevel( characterProgressInfo.getLevel() );
        characterProgress.setTargetExp( characterProgressInfo.getTargetExp() );

        return characterProgress;
    }

    protected CharacterStats characterStatsDataToCharacterStats(CharacterStatsData characterStatsData) {
        if ( characterStatsData == null ) {
            return null;
        }

        CharacterStats characterStats = new CharacterStats();

        characterStats.setPower( characterStatsData.getPower() );
        characterStats.setAgility( characterStatsData.getAgility() );
        characterStats.setIntelligence( characterStatsData.getIntelligence() );
        characterStats.setHitPoints( characterStatsData.getHitPoints() );
        characterStats.setManaPoints( characterStatsData.getManaPoints() );
        characterStats.setAttack( characterStatsData.getAttack() );

        return characterStats;
    }

    protected Map<EquipmentSlot, EquipmentItem> stringEquipmentItemMapToEquipmentSlotEquipmentItemMap(Map<String, EquipmentItem> map) {
        if ( map == null ) {
            return null;
        }

        Map<EquipmentSlot, EquipmentItem> map1 = new HashMap<EquipmentSlot, EquipmentItem>( Math.max( (int) ( map.size() / .75f ) + 1, 16 ) );

        for ( java.util.Map.Entry<String, EquipmentItem> entry : map.entrySet() ) {
            EquipmentSlot key = Enum.valueOf( EquipmentSlot.class, entry.getKey() );
            EquipmentItem value = entry.getValue();
            map1.put( key, value );
        }

        return map1;
    }

    protected GameInventory gameInventoryDataToGameInventory(GameInventoryData gameInventoryData) {
        if ( gameInventoryData == null ) {
            return null;
        }

        GameInventory gameInventory = new GameInventory();

        gameInventory.setGold( gameInventoryData.getGold() );
        gameInventory.setHealingHitPointItems( gameInventoryData.getHealingHitPointItems() );
        gameInventory.setHealingManaPointItems( gameInventoryData.getHealingManaPointItems() );
        gameInventory.setEquipment( stringEquipmentItemMapToEquipmentSlotEquipmentItemMap( gameInventoryData.getEquipment() ) );

        return gameInventory;
    }
}
