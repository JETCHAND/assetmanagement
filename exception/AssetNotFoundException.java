package com.assetmanagement.exception;

	@SuppressWarnings("serial")
	public class AssetNotFoundException extends RuntimeException{

		public AssetNotFoundException(String msg) {
			super(msg);
		}

}
