package relics;

import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import java.util.ArrayList;
import patches.Patch;

public class SoulGem_Demon
  extends CustomRelic {
  public static final String ID = "SoulGem_Demon";
  private static final String IMG = "img/relics/SoulGem_Demon.png";
  
  public SoulGem_Demon() {
    super("SoulGem_Demon", ImageMaster.loadImage("img/relics/SoulGem_Demon.png"), ImageMaster.loadImage("img/relics/outline/SoulGem_Demon.png"), AbstractRelic.RelicTier.BOSS, AbstractRelic.LandingSound.CLINK);
    this.counter = 0;
  }
  private static final String IMG_OTL = "img/relics/outline/SoulGem_Demon.png"; private boolean triggeredThisTurn = false;
  
  public void atBattleStart() {
    this.counter = 0;
  }
  
  public void atTurnStart() {
    this.triggeredThisTurn = false;
  }
  
  public void onUseCard(AbstractCard card, UseCardAction action) {
    if (Patch.isServant(card) != 0 && !this.triggeredThisTurn) {
      this.triggeredThisTurn = true;
      flash();
      addToBot((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, (AbstractRelic)this));
      addToBot((AbstractGameAction)new GainEnergyAction(1));
    } 
  }

  
  public void onCardDraw(AbstractCard card) {
    if (Patch.isServant(card) != 0) {
      flash();
      addToBot((AbstractGameAction)new DrawCardAction(1));
    } 
    
    if (card.type == AbstractCard.CardType.CURSE) {
      flash();
      if (card.type == AbstractCard.CardType.CURSE) {
        flash();
        AbstractPlayer p = AbstractDungeon.player;
        p.hand.moveToExhaustPile(card);
        this.counter++;
      } 
    } 
  }

  
  public void onPlayerEndTurn() {
    if (this.counter > 0) {
      ArrayList<AbstractCard> cl = Patch.getServant(this.counter);
      for (AbstractCard c : cl) {
        addToBot((AbstractGameAction)new MakeTempCardInDiscardAction(c, 1));
      }
      this.counter = 0;
    } 
  }
  
  public boolean canSpawn() {
    return AbstractDungeon.player.hasRelic("MetalShield");
  }
  
  public void obtain() {
    if (AbstractDungeon.player.hasRelic("MetalShield")) {
      AbstractDungeon.player.getRelic("MetalShield").onUnequip();
      instantObtain(AbstractDungeon.player, 0, false);
    } else {
      super.obtain();
    } 
  }


  
  public String getUpdatedDescription() {
    return this.DESCRIPTIONS[0];
  }

  
  public AbstractRelic makeCopy() {
    return (AbstractRelic)new SoulGem_Demon();
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/relics/SoulGem_Demon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */