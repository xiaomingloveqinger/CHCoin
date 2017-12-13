package nxt;

import java.util.concurrent.atomic.AtomicReference;

public class BlockchainImpl implements Blockchain {
	
	private BlockchainImpl() {}
	
	private static BlockchainImpl me = new BlockchainImpl();
	
	public static BlockchainImpl getInstance(){
		return me;
	}
	
	private AtomicReference<BlockImpl> lastBlock = new AtomicReference<>();
	
	@Override
	public Block getLastBlock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getLastBlock(int timestamp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getHeight() {
		BlockImpl block = lastBlock.get();
		return block == null ? 0 : block.getHeight();
	}

	@Override
	public Block getBlock(long blockId) {
		BlockImpl block = lastBlock.get();
		if(block.getId() == blockId){
			return block;
		}
		return BlockDb.findBlock(blockId);
	}

	@Override
	public Block getBlockAtHeight(int height) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasBlock(long blockId) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setLastBlock(BlockImpl block) {
		this.lastBlock.set(block);
	}
	
	public void setLastBlock(BlockImpl prevousBlock , BlockImpl block){
		if(!this.lastBlock.compareAndSet(prevousBlock, block)){
			throw new RuntimeException("last block is no longer previous block");
		};
	}
	
	
}
