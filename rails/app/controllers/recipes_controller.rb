class RecipesController < ApplicationController
	respond_to :json
	skip_before_filter  :verify_authenticity_token
	before_action :set_post, only: [:comments, :show]

	def index
		@recipes = Recipe.all.order(created_at: :desc)
		render json: @recipes.to_json
	end

	def show
		render json: @recipe.to_json
	end

	def create
		@recipe = Recipe.new(recipe_params)
		@recipe.save
		render json: @recipe.to_json
	end

	def comments
		render json: @recipe.root_comments.to_json
	end


private
    # Use callbacks to share common setup or constraints between actions.

    def set_post
    	@recipe = Recipe.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def recipe_params
      params.require(:recipe).permit(:name, :description, :preparation, :target_user)
    end

end