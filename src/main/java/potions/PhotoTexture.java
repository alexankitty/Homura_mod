/*    */ package potions;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
/*    */ import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class PhotoTexture {
/* 11 */   private static final HashMap<String, Texture> textures = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Texture getTexture(String textureString) {
/* 18 */     if (textures.get(textureString) == null) {
/*    */       try {
/* 20 */         loadTexture(textureString);
/* 21 */       } catch (GdxRuntimeException gdxRuntimeException) {}
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 27 */     return textures.get(textureString);
/*    */   }
/*    */ 
/*    */   
/*    */   private static void loadTexture(String textureString) throws GdxRuntimeException {
/* 32 */     Texture texture = new Texture(textureString);
/* 33 */     texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
/* 34 */     textures.put(textureString, texture);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SpirePatch(clz = Texture.class, method = "dispose")
/*    */   public static class DisposeListener
/*    */   {
/*    */     @SpirePrefixPatch
/*    */     public static void DisposeListenerPatch(Texture __Instance) {
/* 46 */       PhotoTexture.textures.entrySet().removeIf(entry -> {
/*    */             if (((Texture)entry.getValue()).equals(__Instance))
/*    */               System.out.println("TextureLoader | Removing Texture: " + (String)entry.getKey()); 
/*    */             return ((Texture)entry.getValue()).equals(__Instance);
/*    */           });
/*    */     }
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/potions/PhotoTexture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */