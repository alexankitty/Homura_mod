package cards;

import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.InstantKillAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

public class Coercion extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Coercion"); public static final String ID = "Coercion";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  
  private static final int COST = 1;
  public static final String IMG_PATH = "img/cards/Coercion_skill.png";
  
  public Coercion() {
    super("Coercion", NAME, "img/cards/Coercion_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.ENEMY);
    this.baseMagicNumber = 0;
    this.magicNumber = this.baseMagicNumber;
    this.exhaust = true;
  }

  
  public void use(AbstractPlayer p, AbstractMonster m) {
    if (m == null) {
      return;
    }
    if (m.type != AbstractMonster.EnemyType.BOSS) {
      float HP = m.currentHealth / m.maxHealth * 100.0F;
      int RadomNum = AbstractDungeon.cardRandomRng.random(1, 100);

      
      if (HP < RadomNum) {
        for (int i = 0; i < 30; i++) {
          AbstractDungeon.effectList.add(new GainPennyEffect((AbstractCreature)p, m.hb.cX, m.hb.cY, p.hb.cX, p.hb.cY, true));
        }
        AbstractDungeon.player.gainGold(30);
        
        if ("Darkling".equals(m.id)) {
          addToBot((AbstractGameAction)new InstantKillAction((AbstractCreature)m));
        } else {
          m.escape();
        } 
      } 
    } 
  }

  
  public void calculateCardDamage(AbstractMonster m) {
    if (m == null) {
      return;
    }
    if (!(AbstractDungeon.getCurrRoom() instanceof com.megacrit.cardcrawl.rooms.MonsterRoomBoss)) {
      this.baseMagicNumber = (int)Math.ceil((1.0D - (m.currentHealth / m.maxHealth)) * 100.0D);
      super.calculateCardDamage(m);
    } 
  }

  
  public AbstractCard makeCopy() {
    return (AbstractCard)new Coercion();
  }

  
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      this.selfRetain = true;
      this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
      initializeDescription();
    } 
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Coercion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */