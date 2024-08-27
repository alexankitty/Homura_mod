/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.InstantKillAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.vfx.GainPennyEffect;
/*    */ 
/*    */ public class Coercion extends CustomCard {
/* 17 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Coercion"); public static final String ID = "Coercion";
/* 18 */   public static final String NAME = cardStrings.NAME;
/* 19 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 1;
/*    */   public static final String IMG_PATH = "img/cards/Coercion_skill.png";
/*    */   
/*    */   public Coercion() {
/* 25 */     super("Coercion", NAME, "img/cards/Coercion_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.ENEMY);
/* 26 */     this.baseMagicNumber = 0;
/* 27 */     this.magicNumber = this.baseMagicNumber;
/* 28 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 33 */     if (m == null) {
/*    */       return;
/*    */     }
/* 36 */     if (m.type != AbstractMonster.EnemyType.BOSS) {
/* 37 */       float HP = m.currentHealth / m.maxHealth * 100.0F;
/* 38 */       int RadomNum = AbstractDungeon.cardRandomRng.random(1, 100);
/*    */ 
/*    */       
/* 41 */       if (HP < RadomNum) {
/* 42 */         for (int i = 0; i < 30; i++) {
/* 43 */           AbstractDungeon.effectList.add(new GainPennyEffect((AbstractCreature)p, m.hb.cX, m.hb.cY, p.hb.cX, p.hb.cY, true));
/*    */         }
/* 45 */         AbstractDungeon.player.gainGold(30);
/*    */         
/* 47 */         if ("Darkling".equals(m.id)) {
/* 48 */           addToBot((AbstractGameAction)new InstantKillAction((AbstractCreature)m));
/*    */         } else {
/* 50 */           m.escape();
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 58 */     if (m == null) {
/*    */       return;
/*    */     }
/* 61 */     if (!(AbstractDungeon.getCurrRoom() instanceof com.megacrit.cardcrawl.rooms.MonsterRoomBoss)) {
/* 62 */       this.baseMagicNumber = (int)Math.ceil((1.0D - (m.currentHealth / m.maxHealth)) * 100.0D);
/* 63 */       super.calculateCardDamage(m);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 69 */     return (AbstractCard)new Coercion();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 74 */     if (!this.upgraded) {
/* 75 */       upgradeName();
/* 76 */       this.selfRetain = true;
/* 77 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 78 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Coercion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */