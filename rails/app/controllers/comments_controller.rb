class CommentsController < ApplicationController
	before_filter :set_comment, only: [:comment]
	respond_to :json
	skip_before_filter :verify_authenticity_token


	def comment
		@comment = Comment.build_from(@recipe, 1, params[:body])
		@comment.save
		respond_with @comment

	end

	

private
	def set_comment
		@recipe = Recipe.find(params[:id])
	end

	def comment_params
		params.require(:comment).permit(:body)
	end

end