package cards;
import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import powers.ZeroEnergePower;

public class Pretend extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Pretend"); public static final String ID = "Pretend";
  public static final String NAME = cardStrings.NAME;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;

  private static final int COST = 0;
  public static final String IMG_PATH = "img/cards/Pretend_skill.png";

  public Pretend() {
    super("Pretend", NAME, "img/cards/Pretend_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
    this.baseMagicNumber = 3;
    this.magicNumber = this.baseMagicNumber;
  }


  public void use(AbstractPlayer p, AbstractMonster m) {
    addToBot((AbstractGameAction)new LoseHPAction((AbstractCreature)p, (AbstractCreature)p, this.magicNumber));
    addToBot((AbstractGameAction)new RemoveDebuffsAction((AbstractCreature)AbstractDungeon.player));
    addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ZeroEnergePower((AbstractCreature)p), this.magicNumber));
  }


  public AbstractCard makeCopy() {
    return (AbstractCard)new Pretend();
  }


  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(-1);
    }
  }
}


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Pretend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */