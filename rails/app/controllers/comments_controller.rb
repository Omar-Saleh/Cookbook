class CommentsController < ApplicationController
	before_filter :set_comment, only: [:comment]
	respond_to :json
	skip_before_filter  :verify_authenticity_token


	def comment
		respond_with @comment = Comment.build_from(@recipe, @current_user, params[:comment][:content])
	end

	

private
	def set_comment
		@recipe = Recipe.find(params[:id])
	end

	def comment_params
		params.require(:comment).permit(:content)
	end

end